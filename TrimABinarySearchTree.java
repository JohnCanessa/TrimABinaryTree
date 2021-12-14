import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 */
public class TrimABinarySearchTree {



    /**
     * Given the root of a binary search tree and the 
     * lowest and highest boundaries as low and high, 
     * trim the tree so that all its elements lies in [low, high].
     * 
     * Depth first search pre-order traversal.
     *  
     * Execution: O(n) - Space: O(n)
     */
    static public TreeNode trimBST(TreeNode root, int low, int high) {
        
        // **** base case ****
        if (root == null) return null;

        // ???? ????
        System.out.print("<<< val: " + root.val);
        if (root.val >= low && root.val <= high)
            System.out.println(" stays");
        else
            System.out.println(" needs to be removed");

            
        // // **** return trim of right child ****
        // if (root.val < low) {
        //     return trimBST(root.right, low, high);
        // }
        
        // // **** return trim of left child ****
        // else if (root.val > high) {
        //     return trimBST(root.left, low, high);
        // }
        
        // // **** recurse on left and right children ****
        // else {

        //     // **** trim root left child ****
        //     root.left = trimBST(root.left, low, high);

        //     // **** trim root right child ****
        //     root.right = trimBST(root.right, low, high);
        // }


        // **** recurse on left and right children ****
        if (root.val >= low && root.val <= high) {
            root.left   = trimBST(root.left, low, high);
            root.right  = trimBST(root.right, low, high);
        } 
        
        // **** replace root with right child ****
        else if (root.val < low) {
            return trimBST(root.right, low, high);
        } 
        
        // **** replace root with left child ****
        else if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        // **** return root ****
        return root;
    }


    /**
     * Test scaffold.
     * 
     * !!! NOT PART OF SOLUTION !!!
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // **** create String[] with values for the BST ****
        String[] strArr = br.readLine().trim().split(",");

        // **** read low ****
        int low = Integer.parseInt(br.readLine().trim());

        // **** read high ****
        int high = Integer.parseInt(br.readLine().trim());

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< strArr.length: " + strArr.length);
        System.out.println("main <<< strArr: " + Arrays.toString(strArr));
        System.out.println("main <<<   high: " + high);
        System.out.println("main <<<    low: " + low);

        // **** generate an Integer[] to build the binary tree ****
        Integer[] arr = new Integer[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals("null") || strArr[i].isEmpty())
                arr[i] = null;
            else
                arr[i] = Integer.parseInt(strArr[i]);
        }

        // ???? ????
        System.out.println("main <<< arr: " + Arrays.toString(arr));
 
        // **** create and populate the binary serach tree ****
        BST bst = new BST();
        bst.root = bst.populate(arr);

        // ???? ????
        System.out.println("main <<<  bst.inOrder: " + bst.inOrder(bst.root));
        System.out.println("main <<< bst.preOrder: " + bst.preOrder(bst.root));




        // ???? ????
        System.out.print("main <<< bst.levelOrderTraversal: ");
        System.out.println(bst.levelOrderTraversal(bst.root).toString());

        // **** ****
        TreeNode trimmed = trimBST(bst.root, low, high);

        // ???? ????
        System.out.print("main <<< bst.levelOrderTraversal: ");
        System.out.println(bst.levelOrderTraversal(trimmed).toString());
    }




}