import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    ArrayList<String> str = new ArrayList<>();
    ArrayList<Points> point = new ArrayList<>();
    str = DataImporting.importFile("testData.txt");
    point = getPoints(str);
    int maxX = findMaxX(point);
    int maxY = findMaxY(point);
    //point = foldY(point, 7, maxY);
    point = foldX(point, 655, maxX);
    //printMe2d(markMap(makeMap(), point));
    System.out.println(countDots(markMap(makeMap(), point)));
    
    //System.out.println(point.size());
    //abs value of x - (2 * fold + 1)
  }

  public static int findMaxY(ArrayList<Points> point){
    int max = 0;
    for(int i = 0; i < point.size(); i++){
      max = Math.max(max, point.get(i).getY());
    }
    return max;
  }

  public static int findMaxX(ArrayList<Points> point){
    int max = 0;
for(int i = 0; i < point.size(); i++){
      max = Math.max(max, point.get(i).getX());
    }
    return max;
  }
  //all we need is a find maxY and find maxX to determine the size of the 2dArray
  public static int countDots(int[][] dots){
    int count = 0;
    for (int row = 0; row < dots.length; row++) {
      for (int col = 0; col < dots[0].length; col++) {
        if(dots[row][col] != 0){
          count++;
        }
      }
    }
    return count;
  }

  public static ArrayList<Points> foldY(ArrayList<Points> point, int a, int max){
    ArrayList<Points> newPoints = new ArrayList<>();
    for(int i = 0; i < point.size(); i++){
      int y = point.get(i).getY();
      if(y >= a + 1){
        int x = point.get(i).getX();
        y = Math.abs(y - max);
        Points p = new Points(x, y);
        newPoints.add(p);
      } else {
        newPoints.add(point.get(i));
      }
    }
    return newPoints;
  }

  public static ArrayList<Points> foldX(ArrayList<Points> point, int b, int max){
ArrayList<Points> newPoints = new ArrayList<>();
    for(int i = 0; i < point.size(); i++){
      int x = point.get(i).getX();
      if(x >= b + 1){
        int y = point.get(i).getY();
        x = Math.abs(x - max);
        Points p = new Points(x, y);
        newPoints.add(p);
      } else {
        newPoints.add(point.get(i));
      }
    }
    return newPoints;
  }

  public static ArrayList<Points> getPoints(ArrayList<String> str){
    ArrayList<Points> points = new ArrayList<>();
    for(int i = 0; i < str.size(); i++){
      String line = str.get(i);
      int a = line.indexOf(",");
      int x = Integer.parseInt(line.substring(0, a));
      int y = Integer.parseInt(line.substring(a + 1));
      //System.out.println(x + " " + y);
      Points p = new Points(x, y);
      points.add(p);
    }

    return points;
  }

  public static int folding(String fileName){
    
    return 0;
  }

  public static void printMe2d(int[][] list) {
    for (int row = 0; row < list.length; row++) {
      for (int col = 0; col < list[0].length; col++) {
        System.out.print(list[row][col]);
      }
      System.out.println();
    }
  }

  public static int[][] makeMap(){
    int[][] map = new int[1500][1500];
    for(int row = 0; row < map.length; row++){
    for(int col = 0; col < map[0].length; col++){
      map[row][col] = 0;
    }
  }
  return map;
  }

  public static int[][] markMap(int[][] map, ArrayList<Points> points){
    for(int i = 0; i < points.size(); i++){
      int x = points.get(i).getX();
      int y = points.get(i).getY();
      map[y][x] += 1;
    }
    return map;
  }
}
