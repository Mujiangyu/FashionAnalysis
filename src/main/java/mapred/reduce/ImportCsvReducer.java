package mapred.reduce;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import pojo.ProductInformation;

import java.io.IOException;

/**
 * #Author :Sino
 * #Date   :2021/11/27 14:24
 * #Describe:
 */
public class ImportCsvReducer extends TableReducer<LongWritable, ProductInformation, NullWritable> {
    @Override
    protected void reduce(LongWritable key, Iterable<ProductInformation> values, Context context) throws IOException, InterruptedException {
        Put put = new Put(Bytes.toBytes(String.valueOf(key.get())));

        for (ProductInformation information : values) {
            put.addColumn(Bytes.toBytes("product_info"), Bytes.toBytes("category"), Bytes.toBytes(information.getCategory()));
            put.addColumn(Bytes.toBytes("product_info"), Bytes.toBytes("subcategory"), Bytes.toBytes(information.getSubcategory()));
            put.addColumn(Bytes.toBytes("product_info"), Bytes.toBytes("name"), Bytes.toBytes(information.getName()));
            put.addColumn(Bytes.toBytes("product_info"), Bytes.toBytes("currentPrice"), Bytes.toBytes(String.valueOf(information.getCurrentPrice())));
            put.addColumn(Bytes.toBytes("product_info"), Bytes.toBytes("rawPrice"), Bytes.toBytes(String.valueOf(information.getRawPrice())));
            put.addColumn(Bytes.toBytes("product_info"), Bytes.toBytes("currency"), Bytes.toBytes(information.getCurrency()));
            put.addColumn(Bytes.toBytes("product_info"), Bytes.toBytes("discount"), Bytes.toBytes(String.valueOf(information.getDiscount())));
            put.addColumn(Bytes.toBytes("product_info"), Bytes.toBytes("likesCount"), Bytes.toBytes(String.valueOf(information.getLikesCount())));
            put.addColumn(Bytes.toBytes("product_info"), Bytes.toBytes("isNew"), Bytes.toBytes(String.valueOf(information.isNew())));
            put.addColumn(Bytes.toBytes("product_info"), Bytes.toBytes("brand"), Bytes.toBytes(information.getBrand()));
            put.addColumn(Bytes.toBytes("product_info"), Bytes.toBytes("brandURL"), Bytes.toBytes(information.getBrandURL()));
            put.addColumn(Bytes.toBytes("product_info"), Bytes.toBytes("colorTypeOne"), Bytes.toBytes(information.getBrandURL()));
            put.addColumn(Bytes.toBytes("product_info"), Bytes.toBytes("smallImageURLOne"), Bytes.toBytes(information.getSmallImageURLOne()));
            put.addColumn(Bytes.toBytes("product_info"), Bytes.toBytes("ImageURLOne"), Bytes.toBytes(information.getImageURLOne()));
            put.addColumn(Bytes.toBytes("product_info"), Bytes.toBytes("colorTypeTwo"), Bytes.toBytes(information.getColorTypeTwo()));
            put.addColumn(Bytes.toBytes("product_info"), Bytes.toBytes("smallImageURLTwo"), Bytes.toBytes(information.getSmallImageURLTwo()));
            put.addColumn(Bytes.toBytes("product_info"), Bytes.toBytes("ImageURLTwo"), Bytes.toBytes(information.getImageURLTwo()));
            put.addColumn(Bytes.toBytes("product_info"), Bytes.toBytes("modelURL"), Bytes.toBytes(information.getModelURL()));
            put.addColumn(Bytes.toBytes("product_info"), Bytes.toBytes("ID"), Bytes.toBytes(String.valueOf(information.getID())));
        }

        context.write(NullWritable.get(), put);
    }
}
