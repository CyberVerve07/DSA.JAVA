use std::collections::HashMap;

/// Question 3: Group Anagrams
///
/// Given an array of strings, group anagrams together.
/// An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
/// typically using all the original letters exactly once.
///
/// Time Complexity: O(n * k log k) where n is the number of strings and k is the max string length
/// Space Complexity: O(n * k)
pub fn group_anagrams(strs: Vec<String>) -> Vec<Vec<String>> {
    let mut map: HashMap<String, Vec<String>> = HashMap::new();

    for s in strs {
        // Sort the string to use as key
        let mut chars: Vec<char> = s.chars().collect();
        chars.sort();
        let sorted: String = chars.into_iter().collect();

        map.entry(sorted).or_insert(Vec::new()).push(s);
    }

    map.into_iter().map(|(_, v)| v).collect()
}

fn main() {
    println!("=== HashMap Question 3: Group Anagrams in Rust ===");

    let strs = vec![
        "eat".to_string(),
        "tea".to_string(),
        "tan".to_string(),
        "ate".to_string(),
        "nat".to_string(),
        "bat".to_string(),
    ];

    let result = group_anagrams(strs);
    println!("Input: [\"eat\", \"tea\", \"tan\", \"ate\", \"nat\", \"bat\"]");
    println!("Output: {:?}", result);
    // Expected: [["eat","tea","ate"],["tan","nat"],["bat"]]
}