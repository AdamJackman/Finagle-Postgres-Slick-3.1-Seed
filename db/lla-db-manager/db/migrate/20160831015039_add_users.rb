class AddUsers < ActiveRecord::Migration
  def change
    create_table(:users, :id => false ) do |t|
      t.integer :id
      t.text    :first_name
      t.text    :last_name
      t.text    :user_name
      t.text    :enc_pass
      t.text    :email
    end
    add_index :users, [:user_name, :enc_pass], :unique => true, :name => "unique_credentials"
  end
end

