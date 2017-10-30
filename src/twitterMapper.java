import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class twitterMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private final IntWritable len = new IntWritable();
    private Text data = new Text();
<<<<<<< HEAD
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
     String[] fields = value.toString().split(";",-1);
	//int count = fields.length();
        if(fields.length >= 3){
		data.set(fields[1].toString());  
		len.set(fields[2].toString().length());	
          	context.write(data, len);
=======
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
      String[] fields = value.getText().toString().split(";");
        data.set(key.toString());
        one.set(fields[2].toString().length());
          context.write(data, one);

    }
>>>>>>> dd2efe803cbbf7670e40b1dff8a14b99f254a021
}
}}
