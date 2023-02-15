package ex5.Priority_queue;

public interface Entry<K,V> {
  /**
   * Returns the key stored in this entry.
   * @return the entry's key
   */
  K getKey(); //prioridade

  /**
   * Returns the value stored in this entry.
   * @return the entry's value
   */
  V getValue();   
}
