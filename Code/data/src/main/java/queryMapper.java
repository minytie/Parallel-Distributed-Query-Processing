
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;



import java.io.IOException;

public class queryMapper extends Mapper<LongWritable,Text, Text, LongWritable> {

    @Override
    public void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, LongWritable>.Context context) throws IOException,InterruptedException{
        String query1 = "http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/instances/dataFromRatingSite10/Review94160";
        String query2 = "http://www4.wiwiss.fu-berlin.de/bizer/bsbm/v01/vocabulary/rating4";
        String str = value.toString();
        String[] info = str.split(">");
        String item1 = info[0].substring(1);
        String item2 = info[1].substring(2);
        if (item1.equals(query1) && item2.equals(query2)) {
            String result = info[2];
            context.write(new Text(result), new LongWritable(1));
        }
        if (item2.equals(query1) && item1.equals(query2)) {
            String result = info[2];
            context.write(new Text(result), new LongWritable(1));
        }
    }
}
