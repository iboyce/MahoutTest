/**
 * Created by xuzhi on 2016/6/24.
 */
package UE;

import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.*;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class myMahout {
    private myMahout() {
    }

    public static void main(String[] args) throws Exception
    {
        DataModel model=new FileDataModel(new File("F:\\AppDev\\CommonData\\RecData.txt"));
        UserSimilarity similarity =new PearsonCorrelationSimilarity(model);
        UserNeighborhood neighborhood =new NearestNUserNeighborhood(2,similarity,model);
        Recommender recommender= new GenericUserBasedRecommender(model,neighborhood,similarity);
        List<RecommendedItem> recommendations =recommender.recommend(1, 2);
        for(RecommendedItem recommendation :recommendations){
            System.out.println(recommendation);
        }
    }
}