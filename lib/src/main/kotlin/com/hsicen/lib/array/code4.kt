package com.hsicen.lib.array/** * 作者：hsicen  8/12/21 16:09 * 邮箱：codinghuang@163.com * 作用： * 描述：Median of Two Sorted Arrays * * (1)There are two sorted arrays nums1 and nums2 of size m and n respectively. * (2)Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)). * (3)You may assume nums1 and nums2 cannot be both empty. */fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {    return when {        nums1.isEmpty() -> {            val size = nums2.size            return if (size % 2 == 0) {                val start = size / 2                (nums2[start - 1] + nums2[start]) / 2.0            } else {                nums2[size / 2] / 1.0            }        }        nums2.isEmpty() -> {            val size = nums1.size            return if (size % 2 == 0) {                val start = size / 2                (nums1[start - 1] + nums1[start]) / 2.0            } else {                nums1[size / 2] / 1.0            }        }        else -> {            val len = nums1.size + nums2.size            var result = 0.0            val target = len / 2            var start1 = 0            var start2 = 0            if (len % 2 == 0) {                while ((start1 + start2) <= target) {                    when {                        start1 < nums1.size && start2 < nums2.size -> {                            if (nums1[start1] <= nums2[start2]) {                                if (start1 + start2 == target || start1 + start2 == target - 1) {                                    result += nums1[start1]                                }                                start1++                            } else {                                if (start1 + start2 == target || start1 + start2 == target - 1) {                                    result += nums2[start2]                                }                                start2++                            }                        }                        start1 < nums1.size -> {                            if (start1 + start2 == target || start1 + start2 == target - 1) {                                result += nums1[start1]                            }                            start1++                        }                        else -> {                            if (start1 + start2 == target || start1 + start2 == target - 1) {                                result += nums2[start2]                            }                            start2++                        }                    }                }                result /= 2            } else {                while ((start1 + start2) <= target) {                    when {                        start1 < nums1.size && start2 < nums2.size -> {                            if (nums1[start1] <= nums2[start2]) {                                if (start1 + start2 == target) {                                    result += nums1[start1]                                }                                start1++                            } else {                                if (start1 + start2 == target) {                                    result += nums2[start2]                                }                                start2++                            }                        }                        start1 < nums1.size -> {                            if (start1 + start2 == target) {                                result += nums1[start1]                            }                            start1++                        }                        else -> {                            if (start1 + start2 == target) {                                result += nums2[start2]                            }                            start2++                        }                    }                }            }            result        }    }}fun main() {    val nums1 = intArrayOf(2)    val nums2 = intArrayOf(1)    println(findMedianSortedArrays(nums1, nums2))}