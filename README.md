# Maximum Gap Problem

The Max-Gap Problem comes from computing the Gene Team Tree of two genomes.

Given a sequence P = ( p[1], p[2], p[3], …, p[n] ), of points on the real line (in sorted order),
we can define the gap g[k]= (p[k+1] - p[k]), k=1,2,...,(n-1).
Then Max-Gap(P) = max { g[k] : k=1,2,3,...,(n-1) }.

We are interested in the dynamic version where we allow deletion of points in P. 
Notice that deletion of an end-point is different from the deletion of an internal point.
  
  * If p[1] is deleted, then it means that g[1] is deleted.
  * If p[n] is deleted, then it means that g[n-1] is deleted.

However, if an internal point, p[k] (1 < k < n) is deleted, then we the new-gap g[k-1]
is given by g'[k-1] = (p[k+1] - p[k-1]) = g[k-1] + g[k].

This will be equivalent to replace the old gaps {g[k-1], g[k]} by
a new gaps g'[k-1] = g[k-1]+g[k].

# Time complexity for n deletes

We are interested in the time complexity of deleting n elements and reporting the maximum after each delete.

[Zhang and Leong](http://online.liebertpub.com/doi/abs/10.1089/cmb.2009.0093) proposed using a max heap to store the gap lengths. This gives a time complexity of O(n lg n) time.

[Wang and Lin](http://ieeexplore.ieee.org/document/5654505/) designed a data structure that solves this in O(n lg lg n) time.

[Wang, Lin, and Yang](http://ieeexplore.ieee.org/document/6674301/) designed a data structure that solves this in O(n α(n)) time, where α(n) is the inverse Ackermann function.

Open problem: Can n deletes be done in O(n) time?

# Solving special cases in O(n) time

As we are unable to solve the full problem in O(n) time, we consider a number of special cases.

## Special case of deleting only in the middle

Observation: gaps can only increase.

Store a single value of max, update it when it increases. This can be done in O(n) time.

## Special case of deleting only from the left.

Observation: no new gaps are formed.

Pre-compute an array M for max { p[i], ..., p[n] }. Max after deletion of p[i] is M[i+1].

## Special case of deleting only at the ends.

One solution is to use the RMQ data structure of [Bender and
Farach-Colton](https://www3.cs.stonybrook.edu/~bender/newpub/BenderFa00-lca.pdf),
which takes O(n) to preprocess the gaps and O(1) to return the max gap for any
interval.

There is a simpler solution using only stacks and lists, whose implementation is found in [here](src/MaxGapNSV.java). Description of the algorithm is forthcoming.

# Refrences

Talk given at Friday Hacks and RAS Group research seminar: http://www.slideshare.net/melvinzhang/quest-for-the-optimal-algorithm
