/*

        for (int l = 0; l < mix.length; l++) {
            arr[s+l] = mix[l];
        }


        why used "s+l" instead of "s" directly ?

        -> You're asking why we use arr[s+l] = mix[l] instead of simply arr[l] = mix[l], with the assumption that s would always be zero.

            So in the recursive call when s = 3, we start filling the original array from index 3 with values from the mix array.
            But if we had just used s = 0 (meaning if we just used arr[l] instead of arr[s+l]),
            then whatever was filled by the previous recursive calls would have been overridden.

            If we were to use just arr[l] = mix[l] instead of arr[s+l] = mix[l]:

            1) Every recursive call would start placing elements at the beginning of the array (index 0)

            2) This would cause each recursive call to overwrite the work done by previous calls

            3) For example:

                a) First recursive call sorts elements in positions 0-2
                b) Second recursive call (with s=3) would incorrectly place its results at positions 0-3, erasing the previous work
                c) The final result would be incorrect - only the last segment processed would retain its sorting




            Here's a visualization of what happens during a merge operation with s=3:

            Original array: [10, 20, 30, 40, 60, 50, 70, 80]
                                          ^       ^       ^
                                          s       m       e

            After recursive sorting of segments:
                            [10, 20, 30, 40, 60, 50, 70, 80]
                                          ^       ^       ^

                             segment 1: [40,60] segment 2: [50,70]

            mix array after merging: [40, 50, 60, 70]

            When copying back:
            - arr[s+0] = mix[0] → arr[3] = 40
            - arr[s+1] = mix[1] → arr[4] = 50
            - arr[s+2] = mix[2] → arr[5] = 60
            - arr[s+3] = mix[3] → arr[6] = 70

            Result: [10, 20, 30, 40, 50, 60, 70, 80]

 */
