
read.table('speed_in_milliseconds.txt') -> speed
colnames(speed) = c("Upper", "Milliseconds")
speed
plot(speed$Upper, speed$Milliseconds, type="l")
plot(log(speed$Upper), log(speed$Milliseconds), type="l")
speed = cbind(speed, LogUpper=log(speed$Upper), LogMS=log(speed$Milliseconds))
speed
lm(LogMS ~ LogUpper, data=speed) -> lmout

#' Return estimate run time in milliseconds.
estimate_run_time = function(upper, lmout){
    exp(predict(lmout, data.frame(LogUpper=log(upper))))
}

#' Print total run time.
estimate_total_run_time = function(upper_1, upper_2, lmout){
    time = 0
    for(upper in upper_1:upper_2){
        time = time + estimate_run_time(upper, lmout) / 1000
    }
    cat("The estimated total run tim is: ", time, " seconds.")
    return(time)
}

estimate_total_run_time(60, 1000, lmout)/3600
