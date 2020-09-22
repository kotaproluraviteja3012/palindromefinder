package com.interview.palindromefinder.service;

import com.interview.palindromefinder.domain.PalindromeEntity;
import com.interview.palindromefinder.model.PalindromeStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PalindromeService {

    @Autowired
    private PalindromeStoreRepository dao;

    public void setPalindromeStoreRepository(PalindromeStoreRepository palindromeStoreRepository) {
        this.dao = palindromeStoreRepository;
    }

    public List<PalindromeEntity> retrieveRecords() {
        List<PalindromeEntity> results = dao.findAll();
        return results;
    }

    public PalindromeEntity saveRecord(PalindromeEntity entity){

        String input = entity.getInput();
        String s = longestPalSubstr(input);
        entity.setInput(s);
        PalindromeEntity rec = dao.save(entity);
        return rec;
    }

    private String longestPalSubstr(String str)
    {
        int n = str.length();

        boolean table[][] = new boolean[n][n];

        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = true;

        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for (int k = 3; k <= n; ++k) {

            for (int i = 0; i < n - k + 1; ++i) {

                int j = i + k - 1;

                if (table[i + 1][j - 1]
                        && str.charAt(i) == str.charAt(j)) {
                    table[i][j] = true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        System.out.print("Longest palindrome substring is; ");
        String substring = str.substring(start, start + maxLength);

        return substring;
    }

}
