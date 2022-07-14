package com.example.testweb.service;

public class algorithm {

    /* 버블 정렬
    * 서로 인접한 두 원소를 검사하여 정렬하는 알고리즘.
    * 인접한 2개의 레코드를 비교하여 크기가 순서대로 되어 있지 않으면 서로 교환한다
    * 선택 정렬과 기본 개념이 유사.
    */
    void bubbleSort(int[] a_Array, int a_size) {
        int temp = 0;
        boolean sorted = false;
        for (int n = a_size; n >= 0; n--) {
            if(sorted)
                break;

            sorted = true;
            for (int i=0; i < n; i++) {
                if (a_Array[i+1] >= a_Array[i])
                    continue;

                temp = a_Array[i];
                a_Array[i] = a_Array[i+1];
                a_Array[i+1] = temp;
                sorted = false;
            }
        }
    }

    /* 선택 정렬
    * 선택 정렬은 말 그대로 현재 위치에 들어갈 데이터를 찾아 선택하는 알고리즘이다.
    * */
    void selectionSort(int[] a_Array, int a_size) {
        for (int i = 0; i < a_size - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < a_size; j++) {
                if (a_Array[j] < a_Array[minIdx])
                    minIdx = j;
            }
            swap(a_Array, i, minIdx);
        }
    }

    private static void swap(int[] a_Array, int i, int minIdx) {
        int tmp = a_Array[i];
        a_Array[i] = a_Array[minIdx];
        a_Array[minIdx] = tmp;
    }

    /* 삽입 정렬
    * 삽입 정렬은 현재 비교하고자 하는 target(타겟)과 그 이전의 원소들과 비교하며 자리를 교환(swap)하는 정렬 방법이다.
    * */
    void insertionSort(int[] a_Array, int a_size) {
        for (int i=1; i< a_size; i++) {
            // 타겟
            int target = a_Array[i];
            int j = i - 1;

            while (j >= 0 && target < a_Array[j]) {
                a_Array[j+1] = a_Array[j];
                j--;
            }

            a_Array[j+1] = target;
        }
    }

    /* 병합 정렬
    *
    * */
    private static int[] sorted;
    void merge_sort(int[] a_Array) {
        sorted = new int[a_Array.length];
        merge_sort(a_Array, 0, a_Array.length-1);
        sorted = null;
    }

    // Top-Down 형식
    void merge_sort(int[] a_Array, int left, int right) {
        // 더이상 쪼개지 못할때, return
        if (left == right) return;

        // 중간.
        int mid = (left + right) / 2;

        merge_sort(a_Array, left, mid);
        merge_sort(a_Array, mid+1, right);

        mergeSort(a_Array, left, mid, right);
    }

    // Down-Top 형식
    void merge_sort2(int[] a_Array, int left, int right) {
        /*
         * 1 - 2 - 4 - 8 - ... 식으로 1부터 서브리스트를 나누는 기준을 두 배씩 늘린다.
         */
        for(int size = 1; size <= right; size += size) {
            /*
             * 두 부분리스트을 순서대로 병합해준다.
             * 예로들어 현재 부분리스트의 크기가 1(size=1)일 때
             * 왼쪽 부분리스트(low ~ mid)와 오른쪽 부분리스트(mid + 1 ~ high)를 생각하면
             * 왼쪽 부분리스트는 low = mid = 0 이고,
             * 오른쪽 부분리스트는 mid + 1부터 low + (2 * size) - 1 = 1 이 된다.
             *
             * 이 때 high가 배열의 인덱스를 넘어갈 수 있으므로 right와 둘 중 작은 값이
             * 병합되도록 해야한다.
             */
            for (int l = 0; l <= right - size; l += (2 * size)) {
                int low = l;
                int mid = l + size - 1;
                int high = Math.min(l + (2 * size) - 1, right);
                mergeSort(a_Array, low, mid, high);        // 병합작업
            }
        }
    }

    void mergeSort(int[] a_Array, int left, int mid, int right) {
        // 왼쪽 리스트 시작점.
        int l = left;
        // 오른쪽 리스트 시작점.
        int r = mid + 1;
        // 채워넣을 배열의 인덱스.
        int idx = left;

        while (l <= mid && r <= right) {
            if (a_Array[l] <= a_Array[r]) {
                sorted[idx] = a_Array[l];
                idx++;
                l++;
            } else {
                sorted[idx] = a_Array[r];
                idx++;
                l++;
            }
        }

        if (l > mid) {
            while(r <= mid) {
                sorted[idx] = a_Array[r];
                idx++;
                r++;
            }
        }
        else {
            while(l <= mid) {
                sorted[idx] = a_Array[l];
                idx++;
                l++;
            }
        }

        for(int i=left; i<= right; i++) {
            a_Array[i] = sorted[i];
        }
    }

    // 제네릭
    public <T> T genericMethod(T t) {

        return t;
    }

    class testClass<E> {
        private E element;
    }
}
