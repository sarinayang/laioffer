import java.util.Scanner;

public class DFSSubsets {
    public static void main(String[] args) throws Exception {
        System.out.println("Please enter a string to find all its subset");
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()) {
            char[] inputS = input.nextLine().toCharArray();
            var solutionPrefix = new StringBuilder();
        
            DFSSubsets dfs_ss = new DFSSubsets();
            dfs_ss.findSubset(inputS, 0, solutionPrefix);
        }

        input.close();
    }

    void findSubset(char[] input, int index, StringBuilder solutionPrefix) {
        if(index == input.length) {
            System.out.println("{" + solutionPrefix + "}");
            return;
        }

        findSubset(input, index + 1, solutionPrefix);
        
        solutionPrefix.append(input[index]);
        findSubset(input, index + 1, solutionPrefix);
        solutionPrefix.deleteCharAt(solutionPrefix.length() - 1);
    }
}
