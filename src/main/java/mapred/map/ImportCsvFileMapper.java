package mapred.map;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import pojo.ProductInformation;

import java.io.IOException;

/**
 * #Author :Sino
 * #Date   :2021/11/27 14:23
 * #Describe:
 */
public class ImportCsvFileMapper extends Mapper<LongWritable, Text, LongWritable, ProductInformation> {
    private final ProductInformation outV = new ProductInformation();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        //过滤
        if (line.contains("\"")) return;
        String[] info = line.split(",");
        //封装商品信息为flowBean
        outV.setCategory(info[0]);
        outV.setSubcategory(info[1]);
        outV.setName(info[2]);
        outV.setCurrentPrice(Double.parseDouble(info[3].trim()));
        outV.setRawPrice(Double.parseDouble(info[4].trim()));
        outV.setCurrency(info[5]);
        outV.setDiscount(Double.parseDouble(info[6].trim()));
        outV.setLikesCount(Integer.parseInt(info[7].trim()));
        outV.setNew(Boolean.parseBoolean(info[8].toLowerCase().trim()));
        outV.setBrand(info[9]);
        outV.setBrandURL(info[10]);
        outV.setColorTypeOne(info[info.length-10]);
        outV.setColorTypeTwo(info[info.length-9]);
        outV.setSmallImageURLOne(info[info.length-8]);
        outV.setImageURLOne(info[info.length-7]);
        outV.setSmallImageURLTwo(info[info.length-6]);
        outV.setImageURLTwo(info[info.length-5]);
        outV.setModelURL(info[info.length-4]);
        outV.setID(Long.parseLong(info[info.length-2].trim()));

        context.write(key, outV);
    }
}
