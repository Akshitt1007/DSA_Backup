package p_HashSet_n_HashMap;
public class a4_Which_to_use {
}

/*

    Open Addressing - better cache performance (not pointer is used here)
    chaining - less sensitive to hash function



	 Feature						            Chaining							      Open Addressing
	---------------------------------------------------------------------------------------------------------------------
	Concept							Each slot has a linked list (keys go outside)	All keys stored inside the table
	Memory							Needs extra memory for linked lists				Fixed memory — no extra space
	Cache Performance				Not great (linked lists scattered)				Cache-friendly (data is contiguous)
	Load Factor (α)					Can go beyond 1									Must be < 1, else performance drops
	Collision Handling				Easy — just append in list						Complex — needs probing logic
	Deletion						Super easy — just remove from list				Complicated — might break probe chain
	Performance (Average)			O(1 + α)										O(1 / (1 - α))
	Performance (Worst)				O(n)											O(n)
	Best For						Lots of collisions / dynamic data				Tight memory / low load factor (< 0.7)

	Verdict:
		→ If memory isn't an issue, and you want stability → use Chaining.
		→ If memory is tight and table rarely fills up → use Open Addressing.

*/