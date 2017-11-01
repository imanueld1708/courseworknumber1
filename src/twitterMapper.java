import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class twitterMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private IntWritable counter = new IntWritable(1);
    private Text data = new Text();

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
     String[] fields = value.toString().split(";",-1);

        if(fields.length == 4){
      		data.set(key.toString());
		      int len = fields[2].length()/5;
          int bin = len*5;

          if(bin <= 140){
            data.set(Integer.toString(bin));
	           context.write(data, counter);}
          }
        }
    }
