class AddAutoIncrementToUsers < ActiveRecord::Migration
  def up
    execute "CREATE SEQUENCE users_id START 100000"
  end
  def down
    execute "DROP SEQUENCE users_id"
  end
end
