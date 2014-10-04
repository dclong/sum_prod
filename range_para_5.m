Import["sum_prod.m"];
For[i = 510, i <= 560, i++,
   n = SolutionNumber[{2, i}]; 
   PutAppend[ToString[i] <> " " <> ToString[n], "rr5.txt"];
];
