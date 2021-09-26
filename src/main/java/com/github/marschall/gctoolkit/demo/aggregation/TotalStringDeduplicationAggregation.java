package com.github.marschall.gctoolkit.demo.aggregation;

import com.microsoft.gctoolkit.aggregator.Aggregation;

public interface TotalStringDeduplicationAggregation extends Aggregation {

  public void addReduction(double reduction);

}
