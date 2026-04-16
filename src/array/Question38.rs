/**
 * Question 38: Majority Element (LeetCode 169)
 * 
 * Problem Statement:
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * 
 * Logic (Boyer-Moore Voting Algorithm):
 * 1. Initialize candidate and count.
 * 2. Traverse the array, adjusting count or candidate.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

pub fn majority_element(nums: Vec<i32>) -> i32 {
    let mut candidate = 0;
    let mut count = 0;

    for num in nums {
        if count == 0 {
            candidate = num;
        }
        
        if num == candidate {
            count += 1;
        } else {
            count -= 1;
        }
    }

    candidate
}

fn main() {
    println!("==========================================");
    println!("           Majority Element (Rust)        ");
    println!("==========================================\n");

    let nums1 = vec![3, 2, 3];
    println!("Input: {:?}", nums1);
    println!("Majority Element: {}", majority_element(nums1));
    println!("------------------------------------------\n");

    let nums2 = vec![2, 2, 1, 1, 1, 2, 2];
    println!("Input: {:?}", nums2);
    println!("Majority Element: {}", majority_element(nums2));
    println!("------------------------------------------\n");
}
