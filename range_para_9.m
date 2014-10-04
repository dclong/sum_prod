Import["sum_prod.m"];
For[i = 590, i <= 597, i++,
   n = SolutionNumber[{2, i}]; 
   PutAppend[ToString[i] <> " " <> ToString[n], "rr9.txt"];
];
