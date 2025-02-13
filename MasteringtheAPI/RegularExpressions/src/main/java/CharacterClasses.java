public class CharacterClasses {
//. (the "dot" metacharacter) that indicates "any character."


   /* Summary of Character Classes in Regular Expressions
    Character classes in regex define a set of characters that can match a single character in an input string. They are enclosed within square brackets [ ] and can include individual characters, ranges, or special constructs.

            1. Simple Character Classes
[abc] → Matches a, b, or c
    Example: [bcr]at matches bat, cat, or rat, but not hat.

            2. Negation (^)
[^abc] → Matches any character except a, b, or c
    Example: [^bcr]at matches hat, but not bat, cat, or rat.

            3. Ranges (-)
[a-z] → Matches any lowercase letter from a to z
[A-Z] → Matches any uppercase letter from A to Z
[0-9] → Matches any digit from 0 to 9
    Example: foo[1-5] matches foo1 to foo5, but not foo6.

            4. Unions ([a-d[m-p]])
[a-d[m-p]] → Matches a-d and m-p (same as [a-dm-p])
    Example: [0-4[6-8]] matches 0, 1, 2, 3, 4, 6, 7, 8, but not 5 or 9.

            5. Intersections (&&)
[a-z&&[def]] → Matches only the common elements (d, e, f)
    Example: [0-5&&[3-9]] matches 3, 4, and 5, but not 0, 1, 2, 6, 7, 8, 9.

            6. Subtraction (&&[^...])
[a-z&&[^bc]] → Matches a-z, but excludes b and c
    Example: [0-9&&[^345]] matches 0-9 except 3, 4, and 5.



\d matches all digits
\s matches spaces
\w matches word characters
Alternatively, a capital letter means the opposite:
\D matches non-digits
\S matches non-spaces
\W matches non-word characters

  EXP:

Enter your regex: .
Enter input string to search: @
I found the text "@" starting at index 0 and ending at index 1.

Enter your regex: .
Enter input string to search: 1
I found the text "1" starting at index 0 and ending at index 1.

Enter your regex: .
Enter input string to search: a
I found the text "a" starting at index 0 and ending at index 1.

Enter your regex: \d
Enter input string to search: 1
I found the text "1" starting at index 0 and ending at index 1.

Enter your regex: \d
Enter input string to search: a
No match found.

Enter your regex: \D
Enter input string to search: 1
No match found.

Enter your regex: \D
Enter input string to search: a
I found the text "a" starting at index 0 and ending at index 1.

Enter your regex: \s
Enter input string to search:
I found the text " " starting at index 0 and ending at index 1.

Enter your regex: \s
Enter input string to search: a
No match found.

Enter your regex: \S
Enter input string to search:
No match found.

Enter your regex: \S
Enter input string to search: a
I found the text "a" starting at index 0 and ending at index 1.

Enter your regex: \w
Enter input string to search: a
I found the text "a" starting at index 0 and ending at index 1.

Enter your regex: \w
Enter input string to search: !
No match found.

Enter your regex: \W
Enter input string to search: a
No match found.

Enter your regex: \W
Enter input string to search: !
I found the text "!" starting at index 0 and ending at index 1.





    */
}
