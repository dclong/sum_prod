Import["sum_prod.m"];
DistributeDefinitions[TwoAddends, TwoFactors, S1, P1, S2, SumProductPuzzle, SolutionNumber];
For[i = 3, i <= 600, i++,
   n = SolutionNumber[{2, i}]; 
   PutAppend[ToString[i] <> " " <> ToString[n], "rr.txt"];
];
