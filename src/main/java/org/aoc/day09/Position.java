package org.aoc.day09;

public record Position(int x, int y) {
    public Position up() {
        return new Position(x - 1, y);
    }

    public Position down() {
        return new Position(x + 1, y);
    }

    public Position left() {
        return new Position(x, y - 1);
    }

    public Position right() {
        return new Position(x, y + 1);
    }

    public boolean isFarAwayFrom(Position other) {
        return Math.abs(this.x - other.x) >= 2 || Math.abs(this.y - other.y) >= 2;
    }

    /**
     * Compares two {@code Position} objects geometrically.
     *
     * @param other the {@code Position} to be compared.
     * @return the value {@code "L"} if the argument {@code Position} is to the left of this {@code Position};
     * the value {@code "R"} if the argument {@code Position} is to the right of this {@code Position};
     * the value {@code "U"} if the argument {@code Position} is to the top of this {@code Position};
     * the value {@code "D"} if the argument {@code Position} is to the bottom of this {@code Position};
     * the value {@code "DL"} if the argument {@code Position} is diagonally down and left of this {@code Position};
     * the value {@code "DR"} if the argument {@code Position} is diagonally down and right of this {@code Position};
     * the value {@code "UL"} if the argument {@code Position} is diagonally up and left of this {@code Position};
     * the value {@code "UR"} if the argument {@code Position} is diagonally up and right of this {@code Position};
     */
    public String compareTo(Position other) {
        if (this.x == other.x) {
            if (this.y > other.y) return "L";
            else return "R";
        } else if (this.y == other.y) {
            if (this.x > other.x) return "U";
            else return "D";
        } else if (this.x < other.x) {
            if (this.y > other.y) return "DL";
            else return "DR";
        } else {
            if (this.y > other.y) return "UL";
            else return "UR";
        }
    }
}
