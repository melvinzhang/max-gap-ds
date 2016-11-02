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

# Refrences

Talk given at Friday Hacks and RAS Group research seminar: http://www.slideshare.net/melvinzhang/quest-for-the-optimal-algorithm
