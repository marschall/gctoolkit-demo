package com.github.marschall.gctoolkit.demo.aggregation;

import com.microsoft.gctoolkit.aggregator.Collates;

@Collates(TotalStringDeduplication.class)
public class TotalStringDeduplicationSummary implements TotalStringDeduplicationAggregation {

  private boolean empty;
  private double totalReduction;

  public TotalStringDeduplicationSummary() {
    this.empty = true;
    this.totalReduction = 0.0d;
  }

  @Override
  public void addDataPoint(double reduction) {
    this.empty = false;
    this.totalReduction += 0.0d;
  }

  @Override
  public boolean hasWarning() {
    return false;
  }

  @Override
  public boolean isEmpty() {
    return this.empty;
  }

  public double getTotalReduction() {
    return this.totalReduction;
  }

}
