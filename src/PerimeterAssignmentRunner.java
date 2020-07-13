import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int count = 0;
        for (Point p : s.getPoints()) {
            count++;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        double result = getPerimeter(s) / getNumPoints(s);
        return result;
    }

    public double getLargestSide(Shape s) {
        //각 포인트로 변을 구해서 최댓값 찾아서 리턴
        Point prevPt = s.getLastPoint();
        double max = 0.0;
        double currDist = 0.0;
        for (Point currPt : s.getPoints()) {
            currDist = prevPt.distance(currPt);
            if (max < currDist) {
                max = currDist;
            }
            prevPt = currPt;
        }
        return max;
    }

    public double getLargestX(Shape s) {
        //들어온 포인드를 한 줄씩 읽고 또 그 안에서 서로 비교? 한 다으 ㅁㅈㄹ 큰 더블값 반환
        Point prevPt = s.getLastPoint(); // prevPt = (1, 3)
        double bigX = prevPt.getX(); // bigX = 1
        double newX = 0.0;
        //s.getPoints 
        for (Point p : s.getPoints()) {
            //p <- (-1, 3)부터 들어옴
            //int x = p.getX(); -1
            newX = p.getX();
            if (bigX < newX) {
                bigX = newX;
            }
        }
        return bigX;
    }
    
    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        return 0.0;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource("example1.txt");
        Shape s = new Shape(fr);
        int pointNums = getNumPoints(s);
        double length = getPerimeter(s);
        double avgLen = getAverageLength(s);
        double max = getLargestSide(s);
        double bigX = getLargestX(s);
        System.out.println("Number of Points = " + pointNums);
        System.out.println("perimeter = " + length);
        System.out.println("Average length of sides = " + avgLen);
        System.out.println("Max sides = " + max);
        System.out.println("Big X value = " + bigX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
