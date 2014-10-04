Import["sum_prod.m"];
For[i = 460, i <= 510, i++,
   n = SolutionNumber[{2, i}]; 
   PutAppend[ToString[i] <> " " <> ToString[n], "rr4.txt"];
];
