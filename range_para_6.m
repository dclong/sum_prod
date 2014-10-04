Import["sum_prod.m"];
For[i = 560, i <= 610, i++,
   n = SolutionNumber[{2, i}]; 
   PutAppend[ToString[i] <> " " <> ToString[n], "rr6.txt"];
];
