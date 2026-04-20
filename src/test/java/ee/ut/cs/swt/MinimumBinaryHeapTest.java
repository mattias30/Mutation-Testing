package ee.ut.cs.swt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MinimumBinaryHeapTest {
	
	private MinimumBinaryHeap heap;
	private List<Integer> result;
	
	@BeforeEach
	public void setUp() {
		heap = new MinimumBinaryHeap();
		result = new ArrayList<>();
		result.add(10);
		result.add(5);
		result.add(4);
		result.add(8);
		result.add(12);
	}
	
	@Test
	public void minHeapifyTest() {
		heap.minHeapify(result);
		assertEquals(4, heap.getArray().get(0), 0);
		assertEquals(5, heap.getArray().get(1), 0);
		assertEquals(10, heap.getArray().get(2), 0);

	}
	
	@Test
	public void extractMinTest() {
		heap.add(7);
		heap.add(1);
		heap.add(6);
		int min = heap.exractMin();
		assertEquals(1, min);
	}
	
	@Test
	public void swapTest() {
		heap.add(5);
		heap.add(8);
		heap.add(13);
		heap.swap(1, 2);
		assertEquals(5, heap.getArray().get(0), 0);
		assertEquals(13, heap.getArray().get(1), 0);
		assertEquals(8, heap.getArray().get(2), 0);
	}
	
	@Test
	public void addTest() {
		heap.add(10);
		heap.add(5);
		heap.add(4);
		heap.add(8);
		heap.add(12);
		assertEquals(4, heap.getArray().get(0), 0);
		assertEquals(5, heap.getArray().get(1), 0);
		assertEquals(10, heap.getArray().get(2), 0);
	}
	
	@Test
	public void removeTest() {
		heap.add(5);
		heap.add(3);
		heap.add(2);
		boolean b1 = heap.remove(3);

		assertEquals(true, b1);
	}

	@Test
	public void isEmptyTest() {
		heap = new MinimumBinaryHeap();
		assertEquals(true, heap.isEmpty());
	}

	@Test
	public void removeLastElement_01() {
		heap.minHeapify(result);
		assertEquals(true, heap.remove(12));
	}

	@Test
	public void isNotEmpty_02() {
		heap.minHeapify(result);
		assertEquals(false, heap.isEmpty());
	}

	@Test
	public void extractMinHeapStructure_03() {
		heap.minHeapify(result);
		heap.exractMin();
		assertEquals(5, heap.exractMin());
	}


	@Test
	public void removeHeapStructureLeaf_04() {
		heap.minHeapify(result);
		heap.remove(4);
		assertEquals(12, heap.getArray().get(3)); // last element

	}

	@Test
	public void removeNonExistingElement_05() {
		heap.minHeapify(result);
        assertFalse(heap.remove(999));
	}

	@Test
	public void extractMinOnEmptyHeap_06() {
		assertThrows(IllegalArgumentException.class, () -> heap.exractMin());
	}

	@Test
	public void bubbleDownLeftChildSmaller_07() {
		heap.add(1);
		heap.add(3); // left child
		heap.add(100); // right child
		heap.add(10);
		heap.remove(1);
		assertEquals(3, heap.exractMin());
	}
}
