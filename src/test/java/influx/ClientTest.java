package influx;

import org.influxdb.BatchOptions;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.junit.Before;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ClientTest {
    InfluxDB influxDB = null;
    Map<Integer, String> shareMap = null;

    @Before
    public void before() {
        String influxDBUrl = "http://172.16.7.42:8086/";
        String userName = "test";
        String password = "test123";
        String database = "testdb";
        if (null == influxDB) {
            influxDB = InfluxDBFactory.connect(influxDBUrl, userName, password);
            try {

                /**
                 * 异步插入：
                 * enableBatch这里第一个是point的个数，第二个是时间，单位毫秒
                 * point的个数和时间是联合使用的，如果满100条或者60 * 1000毫秒
                 * 满足任何一个条件就会发送一次写的请求。
                 */
                influxDB.setDatabase(database).enableBatch(100, 1000 * 60, TimeUnit.MILLISECONDS);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //设置默认策略
//                influxDB.setRetentionPolicy("sensor_retention");
            }
            //设置日志输出级别
            influxDB.setLogLevel(InfluxDB.LogLevel.BASIC);

            shareMap = new HashMap<>();
            shareMap.put(0, "facebook");
            shareMap.put(1, "wechat");
            shareMap.put(2, "twitter");
            shareMap.put(3, "line");
            shareMap.put(4, "qq");
        }

    }

    @Test
    public void test() throws InterruptedException {
        insert("t_share");

//        System.out.println(String.format("%010d", 1));
    }

    //   批量插入1
    private void insert(String measurement) throws InterruptedException {

        Point point = null;
        int val = 0;
        int uid = 0;
        int total = 0;
        while (true){

            List<String> lines = new ArrayList<String>();
            for (int i = 1; i <= 100; i++) {
                val = i % 5;
                uid = (int) (Math.random() * 1000000);
                point = Point.measurement(measurement)
                        .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                        .tag("event", shareMap.get(val))
                        .tag("uid", String.format("%010d", uid))
                        .addField("cnt", val)
                        .addField("usd", Math.random()*10).build();
                lines.add(point.lineProtocol());
                total++;
            }
            influxDB.write(lines); //写入

            Thread.sleep(10000);

            if (total > 100000000){
                break;
            }

        }

    }

    private void batchInsert(String database, String measurement) {
        BatchPoints batchPoints = BatchPoints
                .database(database)
                .consistency(InfluxDB.ConsistencyLevel.ALL)
                .build();
        //遍历sqlserver获取数据
        for (int i = 0; i < 50; i++) {
            //创建单条数据对象——表名
            Point point = Point.measurement(measurement)
                    //tag属性——只能存储String类型
                    .tag("deviceId", "sensor" + i)
                    .addField("temp", 3)
                    .addField("voltage", 145 + i)
                    .addField("A1", "4i")
                    .addField("A2", "4i").build();
            //将单条数据存储到集合中
            batchPoints.point(point);
        }
        //批量插入
        influxDB.write(batchPoints);
    }

    public void sample() throws InterruptedException {
        // Create a database...
// https://docs.influxdata.com/influxdb/v1.7/query_language/database_management/
        String databaseName = "NOAA_water_database";
        influxDB.query(new Query("CREATE DATABASE " + databaseName));
        influxDB.setDatabase(databaseName);

// ... and a retention policy, if necessary.
// https://docs.influxdata.com/influxdb/v1.7/query_language/database_management/
        String retentionPolicyName = "one_day_only";
        influxDB.query(new Query("CREATE RETENTION POLICY " + retentionPolicyName
                + " ON " + databaseName + " DURATION 1d REPLICATION 1 DEFAULT"));
        influxDB.setRetentionPolicy(retentionPolicyName);

// Enable batch writes to get better performance.
        influxDB.enableBatch(BatchOptions.DEFAULTS);

// Write points to InfluxDB.
        influxDB.write(Point.measurement("h2o_feet")
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .tag("location", "santa_monica")
                .addField("level description", "below 3 feet")
                .addField("water_level", 2.064d)
                .build());

        influxDB.write(Point.measurement("h2o_feet")
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .tag("location", "coyote_creek")
                .addField("level description", "between 6 and 9 feet")
                .addField("water_level", 8.12d)
                .build());

// Wait a few seconds in order to let the InfluxDB client
// write your points asynchronously (note: you can adjust the
// internal time interval if you need via 'enableBatch' call).
        Thread.sleep(5_000L);

// Query your data using InfluxQL.
// https://docs.influxdata.com/influxdb/v1.7/query_language/data_exploration/#the-basic-select-statement
        QueryResult queryResult = influxDB.query(new Query("SELECT * FROM h2o_feet"));

        System.out.println(queryResult);
// It will print something like:
// QueryResult [results=[Result [series=[Series [name=h2o_feet, tags=null,
//      columns=[time, level description, location, water_level],
//      values=[
//         [2020-03-22T20:50:12.929Z, below 3 feet, santa_monica, 2.064],
//         [2020-03-22T20:50:12.929Z, between 6 and 9 feet, coyote_creek, 8.12]
//      ]]], error=null]], error=null]

// Close it if your application is terminating or you are not using it anymore.
        influxDB.close();
    }
}
