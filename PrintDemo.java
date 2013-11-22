import java.util.ArrayList;
import java.util.List;

/**
 * Description: PrintDemo
 * User: liushuai
 * Date: 13-11-13
 * Time: 上午10:55
 */
public class PrintDemo {
    public List<int[]> mylist = new ArrayList<int[]>();
    int count = 1;
    int downposition = 0;    //纵坐标
    int direction = 1;        //1  --> 2↓  3←    4↑   方向，默认从右开始

    public void print(int n) {
        int[] stempArray = buildStempArray(n);
        //自定义动态二维数组
        mylist = buildArrayList(n);
        //给二维数组赋值
        for (int i = 0; i < stempArray.length; i++)//循环步数
        {
            if (direction == 1) {
                right(stempArray[i]);
            } else if (direction == 2) {
                down(stempArray[i], n);
            } else if (direction == 3) {
                left(stempArray[i]);
            } else {
                up(stempArray[i]);
            }
        }
        System.out.println(toString());
    }

    private void up(int stemp) {
        downposition = downposition - 1;
        int start = startPosition();
        for (int i = 0; i < stemp; i++) {
            mylist.get(downposition)[start] = count;
            count++;
            downposition--;
        }
        direction = 1;
        downposition++;
    }

    private int startPosition() {
        int start = 0;
        int[] array = mylist.get(downposition);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                start = i;
                break;
            }
        }
        return start;
    }

    private void left(int stemp) {
        int start = downPosition();
        for (int i = 0; i < stemp; i++) {
            mylist.get(downposition)[start] = count;
            start--;
            count++;
        }
        direction = 4;
    }

    private void down(int stemp, int n) {
        int start = downPosition();
        for (int i = 0; i < stemp; i++) {
            mylist.get(downposition)[start] = count;
            count++;
            downposition++;
        }
        direction = 3;
        downposition = downposition - 1;
    }

    private int downPosition() {
        int start = 0;
        int array[] = mylist.get(downposition);
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] == 0) {
                start = i;
                break;
            }
        }
        return start;
    }


    private void right(int stemp) {
        int start = startPosition();
        for (int i = 0; i < stemp; i++) {
            mylist.get(downposition)[start] = count;
            start++;
            count++;
        }
        direction = 2;
        downposition = downposition + 1;
    }

    public int[] buildStempArray(int n) {
        int totalStemp = totalStemp(n);
        int[] stempArray = new int[totalStemp];
        stempArray[0] = n;
        int i = n - 1;
        int m = 1;
        for (; i > 0; i--) {
            for (; m < totalStemp; ) {
                stempArray[m] = i;
                stempArray[m + 1] = i;
                m = m + 2;
                break;
            }
        }
        return stempArray;
    }

    public int totalStemp(int n) {
        return (n - 1) * 2 + 1;
    }

    private List buildArrayList(int n) {
        for (int i = 0; i < n; i++) {
            mylist.add(i, new int[n]);
        }
        return mylist;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mylist.size(); i++) {
            for (int j = 0; j < mylist.get(i).length; j++) {
                sb.append(mylist.get(i)[j] + "\t");
            }
            sb.append("\r\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        PrintDemo p = new PrintDemo();
        int n = 10;
        p.print(n);
    }
}
