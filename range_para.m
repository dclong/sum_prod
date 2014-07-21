Import["sum_prod.m"];
DistributeDefinitions[TwoAddends, TwoFactors, S1, P1, S2, SumProductPuzzle, SolutionNumber];
rr = Table[ParallelSubmit[{i}, SumProductPuzzle[{2, i}]], {i, 61, 600}];
Export["rr.txt", rr, "Table"];
