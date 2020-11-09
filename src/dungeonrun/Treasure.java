package dungeonrun;

import java.util.Scanner;

public class Treasure {

    static Scanner sc = new Scanner(System.in);
    public int valuePoints;
    public String Name;

    public Treasure(int valuePoints, String Name) {
        this.valuePoints = valuePoints;
        this.Name = Name;
    }
    // TODO: Treasure() without parameters will be removed...
    public Treasure() {
        this.valuePoints = 1;
        this.Name = "";
    }
    
    static int findCeil(int arr[], int r, int l, int h) {
        int mid;
        while (l < h) {
            mid = l + ((h - l) >> 1);
            if (r > arr[mid]) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return (arr[l] >= r) ? l : -1;
    }

    static int myRand(int arr[], int freq[], int n) {

        int prefix[] = new int[n], i;
        prefix[0] = freq[0];
        for (i = 1; i < n; ++i) {
            prefix[i] = prefix[i - 1] + freq[i];
        }

        int r = ((int) (Math.random() * (323567)) % prefix[n - 1]) + 1;

        int indexc = findCeil(prefix, r, 0, n - 1);
        return arr[indexc];
    }

    static int pouch = 0;
    static int arr[] = {0, 1, 2, 3, 4, 5};
    static int freq[] = {20, 40, 20, 15, 10, 5};
    static int n = arr.length;
    static boolean loop = true;

    static void treasureRoll() {

        int treasure = (myRand(arr, freq, n));

        switch (treasure) {

            case 0:
                System.out.println("There is no treasure in this room");
                break;
            case 1:
                System.out.println("You found some coins");
                System.out.println("2 gold was added to your pouch");
                pouch += 2;
                break;
            case 2:
                System.out.println("You found a small coin purse");
                System.out.println("6 gold was added to your pouch");
                pouch += 6;
                break;
            case 3:
                System.out.println("You found some golden jewlery");
                System.out.println("10 gold was added to your pouch");
                pouch += 10;
                break;
            case 4:
                System.out.println("You found a gemstone");
                System.out.println("It's worth 14 gold. It was added to your pouch");
                pouch += 14;
                break;
            case 5:
                System.out.println("You found a small treasure chest");
                System.out.println("It's content is worth 20 gold. It was added to your pouch");
                pouch += 20;
            default:
                break;
        }

        System.out.println("You have " + pouch + " gold");
    }
}
