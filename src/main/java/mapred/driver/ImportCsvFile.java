package mapred.driver;

import mapred.map.ImportCsvFileMapper;
import mapred.reduce.ImportCsvReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import pojo.ProductInformation;

import java.io.IOException;

/**
 * #Author :Sino
 * #Date   :2021/11/27 14:23
 * #Describe:
 */
public class ImportCsvFile {
    public static boolean importFile(String filePath, String tableName) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);
        job.setJarByClass(ImportCsvFile.class);

        job.setMapperClass(ImportCsvFileMapper.class);
        job.setMapOutputKeyClass(LongWritable.class);
        job.setMapOutputValueClass(ProductInformation.class);

        TableMapReduceUtil.initTableReducerJob(tableName, ImportCsvReducer.class, job);
        FileInputFormat.setInputPaths(job, new Path(filePath));

        return job.waitForCompletion(true);
    }
}
