class Solution {
    
    public int[] nextSmaller(int[] heights, int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            result[i] = stack.peek();
            stack.push(i);
        }
        return result;
    }

    public int[] previousSmaller(int[] heights, int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            result[i] = stack.peek();
            stack.push(i);
        }
        return result;
    }

    public int largestRectangleArea(int[] heights) {
        int[] next = nextSmaller(heights, heights.length);
        int[] previous = previousSmaller(heights, heights.length);
        int newArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int length = heights[i];

            if (next[i] == -1) {
                next[i] = heights.length;
            }

            int breadth = next[i] - previous[i] - 1;
            int area = length * breadth;
            newArea = Math.max(area, newArea);
        }

        return newArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int area = 0;
        int[] currLevel = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != '0') {
                    currLevel[j] = currLevel[j] + 1;
                } else {
                    currLevel[j] = 0;
                }
            }
            int newArea = largestRectangleArea(currLevel);
            area = Math.max(area, newArea);
        }
        return area;
    }
}
