package pathfinding;

import java.lang.Exception;
import java.util.*;

public class AdjacencyListGraph {
   class EdgeMeta {
      int destVert;
      float weight;
      EdgeMeta(int destVert, float weight) {
         this.destVert = destVert;
         this.weight = weight;
      }
   }
   
   private ArrayList<LinkedList<EdgeMeta>> adjacencies = new ArrayList<LinkedList<EdgeMeta>>();
   
   public AdjacencyListGraph() {
      
   }
   
   public int addVertex() {
      adjacencies.add(new LinkedList<EdgeMeta>());
      return adjacencies.size()-1;
   }

   public void addEdge(int srcVert, int destVert, float weight) throws Exception {
      ListIterator<EdgeMeta> it = adjacencies.get(srcVert).listIterator();
      while (it.hasNext()) {
         if (it.next().destVert == destVert) {
            throw new Exception("Edge already exists from " + srcVert + " to " + destVert);
         }
      }
      it.add(new EdgeMeta(destVert, weight));
   }
}
