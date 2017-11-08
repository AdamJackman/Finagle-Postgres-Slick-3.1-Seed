class ApplySequenceToUsers < ActiveRecord::Migration
  def up
    execute "
      ALTER SEQUENCE users_id OWNED BY users.id;
      ALTER TABLE users ALTER COLUMN id SET DEFAULT nextval('users_id')
    "
  end
  def down
    execute "
      ALTER SEQUENCE users_id OWNED BY NONE;
      ALTER TABLE users ALTER COLUMN users_id SET NOT NULL
    "
  end
end
