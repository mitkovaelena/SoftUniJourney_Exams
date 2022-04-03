package chainblock;

import java.util.*;
import java.util.stream.Collectors;

public class Chainblock implements IChainblock {

    private Map<Integer, Transaction> transactionsById;
    //private SortedMap<TransactionStatus,List<Integer>> transactionsByStatus;
   // private SortedMap<Double,List<Integer>> transactionsByAmount;

    public Chainblock() {
        this.transactionsById = new LinkedHashMap<>();
       // this.transactionsByStatus = new TreeMap<>();
       // this.transactionsByAmount = new TreeMap<>();
    }

    @Override
    public int getCount() {
        return this.transactionsById.size();
    }

    @Override
    public void add(Transaction tx) {
        transactionsById.putIfAbsent(tx.getId(), tx);
     //  transactionsByStatus.putIfAbsent(tx.getStatus(), new ArrayList<Integer>());
     //  transactionsByStatus.get(tx.getStatus()).add(tx.getId());
     //  transactionsByAmount.putIfAbsent(tx.getAmount(), new ArrayList<Integer>());
     //  transactionsByAmount.get(tx.getAmount()).add(tx.getId());
    }

    @Override
    public boolean contains(Transaction tx) {

        return this.transactionsById.containsKey(tx.getId());
    }

    @Override
    public boolean contains(int id) {
        return this.transactionsById.containsKey(id);
    }

    @Override
    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
       if(this.transactionsById.containsKey(id)){
           this.transactionsById.get(id).setStatus(newStatus);
        } else {
           throw new IllegalArgumentException();
       }
    }

    @Override
    public void removeTransactionById(int id) {
        if(this.transactionsById.containsKey(id)){
            this.transactionsById.remove(id);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Transaction getById(int id) {
        if (this.transactionsById.containsKey(id)) {
            return this.transactionsById.get(id);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> transactionList = this.transactionsById.values()
                .stream().filter(x-> x.getStatus().equals(status))
                .sorted((o1, o2) -> (int) Math.ceil(o2.getAmount()-o1.getAmount())).collect(Collectors.toList());
        if (transactionList != null) {
            return transactionList;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<String> transactionList = this.transactionsById.values()
                .stream().filter(x-> x.getStatus().equals(status))
                .map(Transaction::getSender).collect(Collectors.toList());
        if (transactionList != null) {
            return transactionList;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<String> transactionList = this.transactionsById.values()
                .stream().filter(x-> x.getStatus().equals(status))
                .map(Transaction::getReceiver).collect(Collectors.toList());
        if (transactionList != null) {
            return transactionList;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return this.transactionsById.values()
                .stream()
                .sorted((t1, t2) -> {
                    if (t2.getAmount() - t1.getAmount() == 0) {
                        return t1.getId() - t2.getId();
                    } else {
                        return (int) Math.ceil(t2.getAmount() - t1.getAmount());
                    }} ).collect(Collectors.toList());
    }

    @Override
    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        return this.transactionsById.values()
                .stream().filter(x-> x.getSender() != null && x.getSender().equals(sender))
                .sorted((o1, o2) -> (int) Math.ceil(o2.getAmount()-o1.getAmount()))
         .collect(Collectors.toList());
    }

    @Override
    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
         return this.transactionsById.values()
                .stream().filter(x-> x.getReceiver().equals(receiver))
                 .sorted((t1, t2) -> {
                     if (t2.getAmount() - t1.getAmount() == 0) {
                         return t1.getId() - t2.getId();
                     } else {
                         return (int) Math.ceil(t2.getAmount() - t1.getAmount());
                     }} ).collect(Collectors.toList());
    }

    @Override
    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return this.transactionsById.values()
                .stream().filter(x-> x.getStatus().equals(status))
                .filter(x-> x.getAmount() <= amount)
                .sorted((x,y) -> Double.compare(y.getAmount(),x.getAmount())).collect(Collectors.toList());
    }

    @Override
    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
         return this.transactionsById.values()
                .stream().filter(x-> x.getSender().equals(sender))
                .filter(x-> x.getAmount() > amount)
                 .sorted((x,y) -> Double.compare(y.getAmount(),x.getAmount())).collect(Collectors.toList());
    }

    @Override
    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return this.transactionsById.values()
                .stream().filter(x-> x.getReceiver().equals(receiver))
                .filter(x-> x.getAmount() >= lo && x.getAmount() < hi)
                .sorted((x,y) -> Double.compare(y.getAmount(),x.getAmount())).collect(Collectors.toList());
    }

    @Override
    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return this.transactionsById.values()
                .stream().filter(x-> x.getAmount() >= lo && x.getAmount() <= hi).collect(Collectors.toList());
    }

    @Override
    public Iterator<Transaction> iterator() {
        return this.transactionsById.values().iterator();
    }
}
