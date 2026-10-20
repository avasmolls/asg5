
public sealed interface LispList {
    record Empty<A>()                       implements LispList<A> {
        @Override
        public String toString() {
            return "[]";
        }
    }
    record Cons<A>(A head, LispList<A> rest) implements LispList<A> {
        @Override
        public String toString() {
            return "[" + mkString(this, true) + "]";
        }
    }

    //      --------static factory method / "smart const"-----------
    static LispList cons(int x, LispList rest) {
        return new Cons(x, rest);
    }

    static LispList empty() {
        return new LispList.Empty();
    }

    // static LispList of(int[] num)
    static LispList of(int ... nums) { // <-- "variadic argument list"
        var result = LispList.empty();
        for (int i = nums.length - 1; i >= 0; i--) {
            result = LispList.cons(nums[i], result);
        }
        return result;
    }
    // ----------------------------------------------------------------

    /*default String mkString() {
        return mkString(true);
    }*/

    static String mkString(LispList nums, boolean first) {
        return switch(nums) {
            case Empty _                        -> "";
            case Cons(var x, var xs) when first -> x + mkString(xs,false);
            case Cons(var x, var xs)            ->  ", " + x + mkString(xs,false);
        };
    }

    default int length() {
        return switch(this) {
            case Empty _ -> 0;
            case Cons(var x, var xs) -> 1 + xs.length();
        };
    }

    default LispList removeAll(int target) {
        return switch (this) {
            case Empty _ -> LispList.empty();
            case Cons(var x, var xs) when x == target -> xs.removeAll(target);
            case Cons(var x, var xs) ->  LispList.cons(x, xs.removeAll(target));
        };
    }

    default LispList merge(LispList other) {
        return switch (this) {
            case Empty _ -> other;
            case Cons(var x, var xs) ->  LispList.cons(x, other.merge(xs));
        };
    }

}
