package com.example.rest.repository;

import com.example.rest.model.Account;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.jooq.UpdateSetMoreStep;
import java.util.List;
import java.util.Map;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    private final DSLContext dsl;

    public AccountRepositoryImpl(DSLContext dsl) {
        this.dsl = dsl;
    }

    public void save(Account account) {

        dsl.insertInto(table("account"))
                .columns(
                        field("account_id"),
                        field("customer_name"),
                        field("account_type"),
                        field("balance"),
                        field("email"),
                        field("status")
                )
                .values(
                        account.getAccountId(),
                        account.getCustomerName(),
                        account.getAccountType(),
                        account.getBalance(),
                        account.getEmail(),
                        account.getStatus()
                )
                .execute();
    }

    public Account getAccount(Long accountId) {

        return dsl.select()
                .from("account")
                .where(field("account_id").eq(accountId))
                .fetchOneInto(Account.class);
    }

    public List<Account> getAllAccounts() {

        return dsl.select()
                .from("account")
                .fetchInto(Account.class);
    }

    public void updateAccount(Account account) {

        dsl.update(table("account"))
                .set(field("customer_name"),
                        account.getCustomerName())
                .set(field("account_type"),
                        account.getAccountType())
                .set(field("balance"),
                        account.getBalance())
                .set(field("email"),
                        account.getEmail())
                .set(field("status"),
                        account.getStatus())
                .where(field("account_id")
                        .eq(account.getAccountId()))
                .execute();
    }



    public String patchAccount(Long accountId,
                               Map<String, Object> updates) {

        UpdateSetMoreStep<?> update = null;

        for (Map.Entry<String, Object> entry : updates.entrySet()) {

            String column = switch (entry.getKey()) {
                case "customerName" -> "customer_name";
                case "accountType" -> "account_type";
                case "balance" -> "balance";
                case "email" -> "email";
                case "status" -> "status";
                default -> null;
            };

            if (column != null) {
                if (update == null) {
                    update = dsl.update(table("account"))
                            .set(field(column), entry.getValue());
                } else {
                    update = update.set(field(column), entry.getValue());
                }
            }
        }

        if (update != null) {
            update.where(field("account_id").eq(accountId))
                    .execute();
        }
        return null;
    }

    public void deleteAccount(Long accountId) {

        dsl.deleteFrom(table("account"))
                .where(field("account_id").eq(accountId))
                .execute();
    }
}