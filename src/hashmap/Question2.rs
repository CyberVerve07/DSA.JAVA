use std::collections::HashMap;

/// Question 2: Two Sum (HashMap version)
/// 
/// Given an array of integers and a target, find 1-based indices 
/// of two numbers whose sum equals the target.
/// 
/// Time Complexity: O(n)
/// Space Complexity: O(n)
pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
    let mut map = HashMap::new();

    for (i, &num) in nums.iter().enumerate() {
        let complement = target - num;
        
        // If we found the complement in the map, return indices (1-indexed)
        if let Some(&index) = map.get(&complement) {
            return vec![(index + 1) as i32, (i + 1) as i32];
        }
        
        // Otherwise, store current number and its index
        map.insert(num, i);
    }

    vec![-1, -1]
}

fn main() {
    println!("=== HashMap Question 2: Two Sum in Rust ===");
    
    let nums = vec![2, 7, 11, 15];
    let target = 9;
    
    let result = two_sum(nums, target);
    println!("Input: [2, 7, 11, 15], Target: 9");
    println!("Output: {:?}", result); // Expected: [1, 2]

    let nums2 = vec![3, 2, 4];
    let target2 = 6;
    let result2 = two_sum(nums2, target2);
    println!("\nInput: [3, 2, 4], Target: 6");
    println!("Output: {:?}", result2); // Expected: [2, 3]

    let nums3 = vec![3, 3];
    let target3 = 6;
    let result3 = two_sum(nums3, target3);
    println!("\nInput: [3, 3], Target: 6");
    println!("Output: {:?}", result3); // Expected: [1, 2]
}
