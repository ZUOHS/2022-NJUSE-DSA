//此oj需要手动引入工具类，直接用会报“编译或运行失败”，如需要用ArrayList，需要手动引入，
//如：import java.util.ArrayList;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class DirectedGraph {
    private int Vertexnum;
    private int Edgenum;
    private int[][] Edge;

    public DirectedGraph() {
    }
    /**
     * @param Vertexnum  表示顶点的数目，顶点编号为0，Vertexnum-1
     * @param Edge 二维数组，表示边，第一维是边的个数，第二维长度为2，表示一条有向边，分别为出度和入度。
     * @param Edgenum  表示有几条边
     */
    DirectedGraph(int Vertexnum, int[][] Edge, int Edgenum) {
        this.Vertexnum = Vertexnum;
        this.Edge = Edge;
        this.Edgenum = Edgenum;
    }
    /**
     * 如果包括环 返回一个包含环的字符串格式如下“”
     *
     * @param graph  输入的图对象
     * @return  若有环，按升序返回环所在的边的字符串，eg"(1,2)(2,3)(3,1)"，如果不包括则返回空字符串
     */
    public static StringBuilder FindCycle(DirectedGraph graph) {
        // please enter your code here...
        //查看所有边
        int [] vertex = new int[graph.Vertexnum];
        for (int i = 0; i < graph.Vertexnum; i++) {
            vertex[i] = i;
        }
        boolean isFinished = false;
        while (!isFinished) {
            isFinished = true;
            for (int i = 0; i < graph.Vertexnum; i++) {
                int in = 0;
                int out = 0;
                if (vertex[i] == -1) {
                    continue;
                }
                for (int j = 0; j < graph.Edgenum; j++) {
                    if (graph.Edge[j][0] == i) {
                        out++;
                    }
                    if (graph.Edge[j][1] == i) {
                        in++;
                    }
                }
                if (in == 0 || out == 0) {
                    vertex[i] = -1;
                    isFinished = false;
                    for (int j = 0; j < graph.Edgenum; j++) {
                        if (graph.Edge[j][0] == i || graph.Edge[j][1] == i) {
                            graph.Edge[j][0] = -1;
                            graph.Edge[j][1] = -1;
                        }
                    }
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < graph.Edgenum; i++) {
            if (graph.Edge[i][0] != -1) {
                res.append("(" + graph.Edge[i][0] + "," + graph.Edge[i][1] + ")");
            }
        }
        return res;
    }
}