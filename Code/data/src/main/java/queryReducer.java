import java.io.IOException;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class queryReducer extends Reducer<Text, LongWritable,Text,LongWritable>{

    @Override
    public void reduce(Text key, Iterable<LongWritable> values, Reducer<Text, LongWritable,Text,LongWritable>.Context context) throws  IOException,InterruptedException{
        long cont = 0;
        for (LongWritable t:values){
            cont+=t.get();
        }
        context.write(key,new LongWritable(cont));
    }
}
