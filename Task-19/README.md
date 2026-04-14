# Create and switch to feature branch git checkout -b feature/student-api
# Make changes and commit git add .
git commit -m "Add student API endpoints"
# Switch to main and make a conflicting change git checkout main
echo "main change" >> README.md
git commit -am "Update README on main"
# Merge feature branch (creates conflict if same lines changed) git merge feature/student-api
# View conflict markers in file # <<<<<< HEAD
# main change # =======
# feature change
# >>>>>> feature/student-api
# Resolve conflict manually, then:
git add README.md
git commit -m "Merge: resolve README conflict" # Rebase example
git checkout feature/new-feature git rebase main
