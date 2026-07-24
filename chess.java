class Solution {
    public boolean squareIsWhite(String coordinates) {
        int column = coordinates.charAt(0) - 'a';
        int row = coordinates.charAt(1) - '1';

        return (column + row) % 2 == 1;
    }
}