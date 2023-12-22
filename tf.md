Certainly! Here’s an example workflow using GitHub Actions to detect changes between environments using terraform plan and excluding specific files:

name: Check Terraform Environment Changes

on:
  pull_request:
    paths:
      - 'nonprod/**'
      - 'prod/**'
    types: [opened, synchronize]

jobs:
  check_changes:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout code
        uses: actions/checkout@v2

      - name: Setup Terraform
        uses: hashicorp/setup-terraform@v1

      - name: Get Terraform modules
        run: terraform init

      - name: Create Terraform plan for nonprod
        id: plan_nonprod
        run: terraform plan -out nonprod.tfplan nonprod/

      - name: Create Terraform plan for prod
        id: plan_prod
        run: terraform plan -out prod.tfplan prod/

      - name: Get changed resources
        id: diff_changes
        run: |
          terraform show -json nonprod.tfplan > nonprod.json
          terraform show -json prod.tfplan > prod.json
          jq -s '.[0] - .[1]' nonprod.json prod.json > diff.json

      - name: Check for differences and exclude files
        run: |
          jq 'del(.resource_changes[] | select(.change.actions == ["no-op"]))' diff.json > filtered_diff.json
          cat filtered_diff.json

      - name: Label PR if there are differences
        if: steps.check_changes.outputs.filtered_diff != '[]'
        uses: actions/github-script@v4
        with:
          github-token: ${{ secrets.GITHUB_TOKEN }}
          script: |
            github.issues.createComment({
              issue_number: context.issue.number,
              owner: context.repo.owner,
              repo: context.repo.repo,
              body: 'There are changes between nonprod and prod environments.'
            })

This workflow:

	1.	Triggers on pull request opening or when changes occur within the nonprod or prod directories.
	2.	Uses the hashicorp/setup-terraform action to set up Terraform.
	3.	Generates Terraform plans for both nonprod and prod environments.
	4.	Compares the plans using terraform show -json and jq to filter out differences, excluding no-op changes.
	5.	If there are differences, it adds a comment to the pull request using GitHub Actions’ github-script.

You might need to adjust paths or commands according to your specific directory structure and Terraform setup. This workflow should give you a starting point to detect changes between your environments and label the PR accordingly.




-----

Using diff is a decent approach, but for structured comparison and handling exclusions, you might want to consider using tools like terraform plan or a dedicated diffing tool that allows for file exclusions.

To ignore specific files during the diff process, you can use the --exclude flag with diff. For instance, the command might look like this:

diff -rq --exclude='backend.enc.hcl' --exclude='config.auto.tfvars.json' --exclude='secrets.auto.tfvars.enc.json' nonprod/ prod/

This command compares the content of the nonprod and prod directories recursively while excluding the specified files from the comparison. You can incorporate this command into your GitHub Actions workflow to check for differences.

However, for Terraform-specific comparisons, utilizing terraform plan might be more precise as it analyzes the changes based on the Terraform configuration rather than raw file differences. You can redirect the terraform plan output to a file, exclude the files you don’t want to include, and then perform a diff between the generated plan files for the environments.

Would you like an example of how to set up this workflow using terraform plan and handling exclusions?
