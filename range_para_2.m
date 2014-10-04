Import["sum_prod.m"];
For[i = 360, i <= 410, i++,
   n = SolutionNumber[{2, i}]; 
   PutAppend[ToString[i] <> " " <> ToString[n], "rr2.txt"];
];
