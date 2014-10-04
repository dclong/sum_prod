Import["sum_prod.m"];
For[i = 310, i <= 360, i++,
   n = SolutionNumber[{2, i}]; 
   PutAppend[ToString[i] <> " " <> ToString[n], "rr1.txt"];
];
